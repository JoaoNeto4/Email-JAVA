package br.com.email.envioemail;

import java.util.Properties;

import javax.mail.Session;

public class SemAutenticacao {

    /**
     * CREDITOS:
     * https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp
     */
    public static void main(String[] args) {

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.example.com";
        String emailID = "email_me@example.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        ComAutenticacao.enviaEmail(session, emailID, "Assunto Teste", "Teste de corpo de email");
    }

}
