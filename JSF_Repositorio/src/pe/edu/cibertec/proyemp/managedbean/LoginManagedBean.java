package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Login;
import pe.edu.cibertec.proyemp.service.LoginService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class LoginManagedBean {
	
	@SuppressWarnings("unused")
	private String email,password;

	private List<Login> logins = new ArrayList<Login>();
	
	private Login selecLogin = new Login();
	
	private List<Login> valido = new ArrayList<Login>();
	
	private Login login = new Login();

	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;
	

	@PostConstruct
	public void init(){
		logins = Lists.newArrayList(
				loginService.getLoginRepository().findAll());
	}

	public List<Login> getLogins() {
		logins = Lists.newArrayList(
				loginService.getLoginRepository().findAll());
		return logins;
	}

	
	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login getSelecLogin() {
		return selecLogin;
	}

	public void setSelecLogin(Login selecLogin) {
		this.selecLogin = selecLogin;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String  validar() {
		// TODO Auto-generated method stub
		valido = loginService.
				getLoginRepository().findbyEmailandPassword(login.getEmail(), login.getPassword());
		
		System.out.println(valido);
		
		if (valido==null || valido.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Usuario y/o Contraseña incorrectos"
					));
			
			return "/logueo.xhtml";
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Bienvenido " + email+ " actualizado"
					));
			return "/welcome.xhtml?faces-redirect=true";
		}
	}

	public List<Login> getValido() {
		return valido;
	}

	public void setValido(List<Login> valido) {
		this.valido = valido;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
}
