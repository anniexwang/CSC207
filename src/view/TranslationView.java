package view;
import interface_adapter.translation.TranslationController;
import interface_adapter.translation.TranslationState;
import interface_adapter.translation.TranslationViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Objects;

public class TranslationView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "translate"; // Name of the view

    // Controllers and View Models

    private final TranslationController translationController; // not yet initialized
    // UI
    JLabel translateLabel = new JLabel("Select Language");
    JTextField translatePhrase = new JTextField("Enter Your Text Here");
    // array of dropdown languages
    String[] languages = {"Option 1", "Option 2", "Option 3"};
    JComboBox<String> comboBox = new JComboBox<>(languages);

    public TranslationView(TranslationController translationController, TranslationViewModel translationViewModel){}
