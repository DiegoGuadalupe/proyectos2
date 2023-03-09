package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.applayout.DrawerToggle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView2 extends AppLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */

    public MainView2(@Autowired ProyectoService service) {
        UI.getCurrent().getElement().getStyle().set("background-color", "white");
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();
        Label puntos = new Label("Puntos");
        puntos.getElement().getStyle().set("margin-left", "90%");
        addToDrawer(tabs);
        addToNavbar(toggle, title,puntos);
        Div content = new Div();
        H1 hola = new H1("Bienvenido");
        hola.getStyle().set("text-align", "center");
        Div conttexto = new Div();
        Label texto = new Label("Bienvenido a la aplicación de Banco de Alimentos 2. Esta es una continuación donde mejoramos tanto la idea del proyecto\n como la implementación de este. En esta aplicación encontrarás multiples servicios que\n tienen como objetivo distribuir " +
                "y controlar de forma correcta la distribucion de alimentos de los bancos de alimentos");
        texto.getElement().getStyle().set("white-space", "pre-wrap");
        conttexto.getElement().getStyle().set("margin-left", "26%");
        conttexto.add(texto);
        content.add(hola, new Hr(), conttexto);
        setContent(content);






    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.add(createTab(VaadinIcon.USER_HEART, "Inicio"),
                createTab(VaadinIcon.CART, "Ver Alimentos"),
                createTab(VaadinIcon.LIST, "Valoraciones"),
                createTab(VaadinIcon.PACKAGE, "Contacto"));

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
            return tabs;
       /* Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto");
        tabs.add(createTab("Dashboard"), createTab("Orders"),
                createTab("Customers"), createTab("Products"));
        return tabs;*/
    }

    private Tab createTab(VaadinIcon viewIcon, String viewName) {
        Icon icon = viewIcon.create();
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }
    private Tab createTab(String viewName) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}
