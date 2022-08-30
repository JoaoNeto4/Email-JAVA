package br.com.email.envioemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class ComAutenticacaoTLS {

    /**
     * CREDITOS:
     * https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp
     */
    public static void main(String[] args) {
        final String remetente = "myemailid@gmail.com"; //email de quem envia(válido)
        final String senha = "mypassword"; // senha de quem envia
        final String destinatario = "myemail@yahoo.com"; // quem recebe

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //Porta TLS
        props.put("mail.smtp.auth", "true"); //autenticação ativa
        props.put("mail.smtp.starttls.enable", "true"); //STARTTLS ativo

        //cria objeto autenticador de argumento Session.getInstance 
        Authenticator auth = new Authenticator() {
            //override getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        };
        Session session = Session.getInstance(props, auth);

        ComAutenticacao.enviaEmail(session, destinatario, "TLSEmail Assunto", "Corpo do Email");

    }

}
