package com.example.demo.gui;

import com.example.demo.model.UnitForExchange;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Route("")
@StyleSheet("/css/style.css")
public class CurrencyExchangeGui extends VerticalLayout {
    public CurrencyExchangeGui() {
        Client client = ClientBuilder.newClient();
        TextField textFieldAmount = new TextField("Podaj kwotę");

        ComboBox<String> comboBoxHaveCurrency = new ComboBox<>("Waluta");
        comboBoxHaveCurrency.setItems("EUR", "PLN", "USD");

        Button buttonConvert = new Button("Przelicz na", new Icon(VaadinIcon.ARROW_RIGHT));
        buttonConvert.setIconAfterText(true);

        ComboBox<String> comboBoxWantCurrency = new ComboBox<>("Waluta");
        comboBoxWantCurrency.setItems("EUR", "PLN", "USD");

        Label labelAfterConversion = new Label();
        buttonConvert.addClickListener(buttonClickEvent -> {
            UnitForExchange requestDto = new UnitForExchange();
            requestDto.setAmount(new BigDecimal(textFieldAmount.getValue()));
            requestDto.setHaveCurrency(comboBoxHaveCurrency.getValue());
            requestDto.setWantCurrency(comboBoxWantCurrency.getValue());

            BigDecimal response = client.target("http://localhost:8080/api/exchange")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(requestDto, MediaType.APPLICATION_JSON))
                    .readEntity(BigDecimal.class);

            labelAfterConversion.setText(String.valueOf(response));
        });


        add(textFieldAmount, comboBoxHaveCurrency, buttonConvert, comboBoxWantCurrency, labelAfterConversion);
    }
}
