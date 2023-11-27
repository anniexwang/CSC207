package view;

import interface_adapter.ViewManagerModel;
 import javax.swing.*;
 import java.awt.*;
 import java.beans.PropertyChangeEvent;
 import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        System.out.println("reached property change");
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
//            System.out.println("reches if branch evt");
            cardLayout.show(views, viewModelName);
        }
        else if(evt.getPropertyName().equals("state")){
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}