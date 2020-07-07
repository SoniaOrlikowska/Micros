package micros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

    public class MyButton extends JButton {
        private boolean rounded;
        private boolean backgroundPainted;
        private boolean linePainted;
        private boolean entered;
        private boolean pressed;
        private boolean clicked;

        private Color enteredColor;
        private Color pressedColor;
        private Color clickedColor;
        private Color gradientBackgroundColor;
        private Color gradientLineColor;
        private Color lineColor;
        private Color buttonColor;

        public MyButton(Color color) {
            super();
            rounded = false;
            backgroundPainted = true;
            linePainted = true;
            entered = false;
            pressed = false;
            clicked = false;
            buttonColor=color;

            setContentAreaFilled(false);
            setFocusPainted(false);
            setOpaque(false);
            setBorder(null);

            addMouseListener(new MouseAdapter() {


                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    pressed = true;
                    MyButton.super.setBorder(null);
                    MyButton.super.setBorderPainted(false);
                    MyButton.super.setBackground(new java.awt.Color(250,20,215).brighter());
                    MyButton.super.setBorderPainted(true);
                    MyButton.super.setForeground(Color.WHITE);
                    gradientBackgroundColor = buttonColor.darker();
                    lineColor= new java.awt.Color(250,20,215);
                    gradientLineColor = Color.BLUE.brighter();

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    MyButton.super.setBorder(null);
                    MyButton.super.setBorderPainted(false);
                    MyButton.super.setBackground(Color.WHITE);
                    MyButton.super.setForeground(new java.awt.Color(250,20,215));
                    MyButton.super.setBorderPainted(true);
                    gradientBackgroundColor = Color.WHITE;

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    MyButton.super.setBorder(null);
                    MyButton.super.setBorderPainted(false);
                    MyButton.super.setBackground(new java.awt.Color(250,20,215).brighter());
                    MyButton.super.setBorderPainted(true);
                    MyButton.super.setForeground(Color.WHITE);
                    gradientBackgroundColor = Color.BLUE;
                    lineColor= new java.awt.Color(250,20,215).brighter();
                    gradientLineColor = Color.BLUE.brighter();

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    MyButton.super.setBorder(null);
                    MyButton.super.setBorderPainted(false);
                    MyButton.super.setBackground(Color.WHITE);
                    MyButton.super.setForeground(new java.awt.Color(250,20,215));
                    MyButton.super.setBorderPainted(true);
                    gradientBackgroundColor = Color.WHITE;

                }
            });


        }
        @Override
        public void setBackground(Color color) {
            super.setBackground(color);
            enteredColor = color.brighter();
            pressedColor = color.darker();
            clickedColor = color.darker();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintChildren(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape s = (rounded) ? new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, getHeight() - 2, getHeight() - 2)
                    : new Rectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2);

            if (backgroundPainted || (pressed && !backgroundPainted)) {
                if (gradientBackgroundColor == null) {
                    g2.setColor(color());
                } else {
                    GradientPaint paint = new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), gradientBackgroundColor);
                    g2.setPaint(paint);
                }
                g2.fill(s);
            }

            if (linePainted) {
                if (gradientLineColor == null) {
                    g2.setColor(isEnabled() ? lineColor : new Color(204, 204, 204));
                } else {
                    GradientPaint paint = new GradientPaint(0, 0, lineColor, getWidth(), getHeight(), gradientLineColor);
                    g2.setPaint(paint);
                }
                g2.setStroke(new BasicStroke(2));
                g2.draw(s);
            }
            super.paintComponent(g);
        }

        private Color color() {
            if (!isEnabled()) {
                return new Color(204, 204, 204);
            }
            Color temp = getBackground();
            if (entered) return enteredColor;
            if (pressed) return pressedColor;
            if (clicked) return clickedColor;
            return temp;
        }

        public void setRounded(boolean rounded) {
            this.rounded = rounded;
        }

        public void setBackgroundPainted(boolean backgroundPainted) {
            this.backgroundPainted = backgroundPainted;
        }

        public void setLinePainted(boolean linePainted) {
            linePainted = linePainted;
        }

        public void setEnteredColor(Color enteredColor) {
            this.enteredColor = enteredColor;
        }

        public void setPressedColor(Color pressedColor) {
            this.pressedColor = pressedColor;
        }

        public void setGradientBackgroundColor(Color gradientBackgroundColor) { this.gradientBackgroundColor = gradientBackgroundColor; }

        public void setLineColor(Color lineColor) {
            this.lineColor = lineColor;
        }

        public void setGradientLineColor(Color gradientLineColor) {
            this.gradientLineColor = gradientLineColor;
        }



    }

