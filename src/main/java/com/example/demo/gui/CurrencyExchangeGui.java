package com.example.demo.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
@StyleSheet("/css/style.css")
public class CurrencyExchangeGui extends VerticalLayout {
    public CurrencyExchangeGui() {
        TextField textFieldKwota = new TextField("Podaj kwotę");
        Button buttonPrzelicz = new Button("Przelicz", new Icon(VaadinIcon.ARROW_RIGHT));
        buttonPrzelicz.setIconAfterText(true);
        Label labelPoPrzeliczeniu = new Label();

        buttonPrzelicz.addClickListener(buttonClickEvent -> {
            labelPoPrzeliczeniu.setText(textFieldKwota.getValue());
        });

        add(textFieldKwota, buttonPrzelicz, labelPoPrzeliczeniu);
    }
}
