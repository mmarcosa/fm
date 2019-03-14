package br.com.fm.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.TX.Transacional;
import br.com.fm.enumeracao.StatusEnum;
import br.com.fm.enumeracao.TipoResultadoEnum;
import br.com.fm.facade.TimeFacade;
import br.com.fm.facade.UsuarioFacade;
import br.com.fm.model.Time;
import br.com.fm.model.Usuario;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class UsuarioMB implements Serializable {

		private static final long serialVersionUID = 1L;

		private Usuario usuario = new Usuario();
		
		private Integer usuarioId;
		
		@Inject	private FacesContext context;
			
		@Inject	private UsuarioFacade usuarioFacade;
		
		@Inject private TimeFacade timeFacade;
		
		private List<Time> times;
		
		private List<SelectItem> descricoesTipoStatus;
		
		@PostConstruct
		public void init() {
			criaTiposStatus();
			criaTimes();
		}
		
		public UsuarioMB() {

		}
		
		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Integer getUsuarioId() {
			return usuarioId;
		}

		public void setUsuarioId(Integer usuarioId) {
			this.usuarioId = usuarioId;
		}

		@Transacional
		public RedirectView gravar(){
			System.out.println("Gravando usuario: " + this.usuario.getEmail());
			if (this.usuario.getId() == null) {
				usuarioFacade.save(this.usuario);
			} else {
				usuarioFacade.update(this.usuario);
			}
			this.usuario = new Usuario();
			return new RedirectView("usuario");
		}
		
		public List<Usuario> getUsuarios() {
			return usuarioFacade.selectAll();
		}

		@Transacional
		public void delete(Usuario usuario) {
			System.out.println("Removendo usuario: " + usuario.getEmail());
			usuarioFacade.delete(usuario);
		}

		public void select(Usuario usuario) {
			System.out.println("Carregando usuario: " + usuario.getEmail());
			this.usuario = usuario;
		}

		public void selectById() {
			this.usuario = usuarioFacade.selectById(usuarioId);
			if (this.usuario == null) {
				this.usuario = new Usuario();
			}
		}
		
		private void criaTimes() {
			times = timeFacade.selectAll();
		}
		
		public String getTipoStatus(String codigo) {
			return StatusEnum.busca(codigo).getDescricao();
		}
		
		private void criaTiposStatus(){
			StatusEnum[] tiposStatus = StatusEnum.values();
			descricoesTipoStatus = new ArrayList<>(tiposStatus.length);
			for(StatusEnum se : tiposStatus) {
				descricoesTipoStatus.add(new SelectItem(se.getCodigo(), se.getDescricao()));
			}
			
		}

}
