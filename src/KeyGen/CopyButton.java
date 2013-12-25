package KeyGen;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *Copy to Clipboard Button
 * @author Alex Wang.
 * @version 0.1
 */
@SuppressWarnings("serial")
public class CopyButton extends JButton
{
    private Action genAction;
    
    /**
     * Constructor
     * 
     */
    public CopyButton()
    {
        setAction(genAction = new GenerateAction());
    }
    
    /**
     * Action for "Copy to Clipboard" button.
     * 
     */
    public final class GenerateAction extends AbstractAction
    {
        private GenerateAction()
        {
            putValue(Action.NAME, "Copy to Clipboard");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                    KeyEvent.VK_ENTER, Toolkit.getDefaultToolkit()
                    .getMenuShortcutKeyMask()));
        }
        
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            if (MainFrame.getKey().length() == 0)
            {
                JOptionPane.showMessageDialog(getRootPane(),
                        "There's nothing to copy!", "Error!",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            String key = MainFrame.getKey();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(key);
            clipboard.setContents(strSel, null);
            }
        }
    }
}
