package cl.biblioteca;

import cl.biblioteca.controller.BibliotecaController;
import cl.biblioteca.view.LoginDialog;
import cl.biblioteca.view.MainFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
            catch (Exception ignored) { }
            LoginDialog login = new LoginDialog(null);
            login.setVisible(true);
            if (login.getUsuarioAutenticado() != null) {
                BibliotecaController controller = new BibliotecaController(login.getUsuarioAutenticado());
                new MainFrame(controller).setVisible(true);
            } else System.exit(0);
        });
    }
}
