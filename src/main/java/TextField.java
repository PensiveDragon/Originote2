import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JTextField {
    void createSearchTextField(String initialText, String toolTip) {
        setToolTipText(toolTip);
        setText(initialText);
        setPreferredSize(new Dimension(400,30));
        setForeground(Color.GRAY);
        addFocusListener(new FocusListener() {
            private boolean jSearchTextFieldClicked = false;

            @Override
            public void focusGained(FocusEvent e) {
                if (!jSearchTextFieldClicked) {
                    setText("");
                    setForeground(Color.BLACK);
                    jSearchTextFieldClicked = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }
}
