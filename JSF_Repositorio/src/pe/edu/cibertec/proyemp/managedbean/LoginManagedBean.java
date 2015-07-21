package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import org.springframework.web.servlet.HttpServletBean;

import pe.edu.cibertec.proyemp.model.Login;
import pe.edu.cibertec.proyemp.service.LoginService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class LoginManagedBean {
	
	private String email,password;


	private List<Login> logins = new ArrayList<Login>();
	
	private Login selecLogin = new Login();
	
	private Login valido = new Login();

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
		valido = loginService.getLoginRepository().getValidarUsuarioyPassword(
				email, password);
		
		if (valido==null || valido.equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Usuario y/o Contraseña incorrectos"
					));
			
			return "logueo";
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Bienvenido " + email+ " actualizado"
					));
			return "welcome";
		}
		
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
