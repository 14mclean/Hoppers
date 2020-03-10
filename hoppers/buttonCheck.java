/*if(source.hashCode() == previousButton.hashCode())
        {
            currentBoard.close();
            currentBoard = null;
            currentLevel--;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);

            if(currentLevel == 1)
            {
                previousButton.setEnabled(false);
            }
            else
            {
                previousButton.setEnabled(true);
            }

            if(currentLevel == 40)
            {
                nextButton.setEnabled(false);
            }
            else
            {
                nextButton.setEnabled(true);
            }
        }
        else if(source.hashCode() == nextButton.hashCode())
        {
            if(currentLevel == 0)
            {
                currentBoard = new Board(1);
                startNanoTime = System.nanoTime();
                currentLevel++;
                levelDisplay.setText("Level: " + currentLevel);
                return;
            }
            if(currentLevel == 40)
            {
                endNanoTime = System.nanoTime();
                currentBoard.close();
                currentBoard = null;
                levelDisplay.setText("Timer Stopped");
                currentLevel = 0;
                
                if(wins == 40)
                {
                    JOptionPane.showMessageDialog(decisionWin, "Total time taken for 40 levels: " + (double) (endNanoTime-startNanoTime)/1000000000.00 + "s", "Time Taken", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(decisionWin, "Did not complete all 40 levels", "Error", JOptionPane.ERROR_MESSAGE);
                }
                wins = 0;
                currentLevel = 0;
            }
            currentBoard.close();
            currentBoard = null;
            currentLevel++;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);

            if(currentLevel == 41)
            {
                nextButton.setEnabled(false);
            }
            else
            {
                nextButton.setEnabled(true);
            }

            if(currentLevel <= 1)
            {
                previousButton.setEnabled(false);
            }
            else
            {
                previousButton.setEnabled(true);
            }
        }*/