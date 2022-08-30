package br.com.email.envioemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class ComAutenticacaoSSL {

    /**
     * CREDITOS:
     * https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp
     */
    public static void main(String[] args) {
        final String remetente = "myemailid@gmail.com"; ////email de quem envia(válido)
        final String senha = "mypassword"; // senha de quem envia
        final String destinatario = "myemail@yahoo.com"; // quem recebe

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); // Porta SSL
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); // SMTP Autenticação ativa
        props.put("mail.smtp.port", "465"); //SMTP Porta

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Sessão criada");
        EmailUtil.enviaEmail(session, destinatario, "SSLEmail Assunto", "SSLEmail Corpo Email");

        EmailUtil.enviaEmailComAnexo(session, destinatario, "SSLEmail Assunto de teste com anexo", "SSLEmail Corpo do email com anexo");

        EmailUtil.enviaEmailComAnexo(session, destinatario, "SSLEmail Assunto de teste com imagem", "SSLEmail Corpo do email com imagem");

    }

}
