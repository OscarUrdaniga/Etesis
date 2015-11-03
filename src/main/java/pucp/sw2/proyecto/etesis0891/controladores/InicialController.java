/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vea
 */
//@Controller("inicialController")
//public class InicialController {
    
//    @Autowired
//    private PersonaDAO personaDAO;
    
//    @RequestMapping("/inicial/inicio")
//    public String index(Model model) {
//        return "index";
//    }
    
//    @RequestMapping("/inicial/login")
//    public String loguear(Model model) {
//        return "redirect:/login.do";
//    }
    
    
//    @RequestMapping("/inicial/recuperarpassword")
//    public String recuperarContrasena(Model model) {
//        CodigoDTO codigo = new CodigoDTO();
//        model.addAttribute("CodigoDTO", codigo);
 //       return "inicial/recuperarpassword";
 //   }
    
 //   @RequestMapping("/inicial/recuperar")
 //   public String recuperar(@ModelAttribute("CodigoDTO") @Valid CodigoDTO codigo, BindingResult result, Model model) {
 //       if (result.hasErrors()) {
 //       // No pasó validación. Retornamos al formulario y mostramos los errores
 //           model.addAttribute("CodigoDTO", codigo);
 //           return "/inicial/recuperarpassword";
 //       } else {
 //           boolean validar = personaDAO.personaRegistrada(codigo.getCodigo());
 //           if (validar) {
 //               PersonaDTO persona = personaDAO.obtenerPersona(codigo.getCodigo());
 //               MailDAO mail = new MailDAO();
 //               String contrasenia = UUID.randomUUID().toString();
 //               System.out.println("password: " + password);
 //               personaDAO.cambiarPassword(codigo.getCodigo(), password);
 //               mail.send(persona.getCorreo(), "Etesis: Nueva Contraseña", "Hola " + persona.getNombres() + ", esta es tu nueva contraseña para acceder a tu cuenta, te recomendamos cambiarla por una que recuerdes con mayor facilidad: " + contrasenia);
 //               return "redirect:/inicial/login";
 //           } else {
 //               model.addAttribute("error", 2);
 //               model.addAttribute("CodigoDTO", codigo);
 //               return "/inicial/recuperarpassword";
 //           }
 //       }
 //   }
    
//}
