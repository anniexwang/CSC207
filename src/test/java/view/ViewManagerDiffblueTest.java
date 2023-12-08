package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import interface_adapter.ViewManagerModel;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

class ViewManagerDiffblueTest {
    /**
     * Method under test:
     * {@link ViewManager#ViewManager(JPanel, CardLayout, ViewManagerModel)}
     */
    @Test
    void testConstructor() {
        JPanel views = new JPanel(true);
        CardLayout cardLayout = new CardLayout(1, 1);

        ViewManager actualViewManager = new ViewManager(views, cardLayout, new ViewManagerModel());
        actualViewManager.propertyChange(new PropertyChangeEvent("42", "foo", "42", "42"));
        assertEquals("PanelUI", views.getUIClassID());
        assertEquals(0, views.getComponentCount());
        assertEquals(0, views.getDebugGraphicsOptions());
        assertEquals(0, views.getHeight());
        assertEquals(0, views.getWidth());
        assertEquals(0, views.getX());
        assertEquals(0, views.getY());
        assertEquals(0, views.getComponentListeners().length);
        assertEquals(0, views.getFocusListeners().length);
        assertEquals(0, views.getHierarchyBoundsListeners().length);
        assertEquals(0, views.getHierarchyListeners().length);
        assertEquals(0, views.getInputMethodListeners().length);
        assertEquals(0, views.getKeyListeners().length);
        assertEquals(0, views.getMouseListeners().length);
        assertEquals(0, views.getMouseMotionListeners().length);
        assertEquals(0, views.getMouseWheelListeners().length);
        assertEquals(0, views.getPropertyChangeListeners().length);
        assertEquals(0, views.getComponents().length);
        assertEquals(0, views.getContainerListeners().length);
        assertEquals(0, views.getAncestorListeners().length);
        assertEquals(0, views.getRegisteredKeyStrokes().length);
        assertEquals(0, views.getVetoableChangeListeners().length);
        assertEquals(0.5f, views.getAlignmentX());
        assertEquals(0.5f, views.getAlignmentY());
        assertEquals(Component.BaselineResizeBehavior.OTHER, views.getBaselineResizeBehavior());
        assertFalse(views.getIgnoreRepaint());
        assertFalse(views.hasFocus());
        assertFalse(views.isCursorSet());
        assertFalse(views.isDisplayable());
        assertFalse(views.isFocusOwner());
        assertFalse(views.isLightweight());
        assertFalse(views.isMaximumSizeSet());
        assertFalse(views.isMinimumSizeSet());
        assertFalse(views.isPreferredSizeSet());
        assertFalse(views.isShowing());
        assertFalse(views.isValid());
        assertFalse(views.isFocusCycleRoot());
        assertFalse(views.isFocusTraversalPolicyProvider());
        assertFalse(views.isFocusTraversalPolicySet());
        assertFalse(views.getAutoscrolls());
        assertFalse(views.getInheritsPopupMenu());
        assertFalse(views.isManagingFocus());
        assertFalse(views.isPaintingForPrint());
        assertFalse(views.isPaintingTile());
        assertFalse(views.isValidateRoot());
        assertTrue(views.getFocusTraversalKeysEnabled());
        assertTrue(views.isBackgroundSet());
        assertTrue(views.isEnabled());
        assertTrue(views.isFocusable());
        assertTrue(views.isFontSet());
        assertTrue(views.isForegroundSet());
        assertTrue(views.isVisible());
        assertTrue(views.getVerifyInputWhenFocusTarget());
        assertTrue(views.isDoubleBuffered());
        assertTrue(views.isOpaque());
        assertTrue(views.isOptimizedDrawingEnabled());
        assertTrue(views.isRequestFocusEnabled());
        Rectangle boundsResult = views.bounds();
        assertEquals(boundsResult, views.getBounds());
        assertEquals(boundsResult, views.getVisibleRect());
        Dimension expectedSize = views.size();
        assertEquals(expectedSize, views.getSize());
        Dimension expectedPreferredSize = views.getMinimumSize();
        assertEquals(expectedPreferredSize, views.getPreferredSize());
    }


}
