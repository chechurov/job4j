package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    //Первый вариант isWin().
    /*public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        int[] count = new int[table.length * 2];
        //Проходим весь массив и записываем сколько найдено единиц в каждой строке и столбце.
        for (int i = 0; i != table.length; i++) {
            for (int j = 0; j != table.length; j++) {
                if (table[i][j] == 1) {
                    count[i] += 1; //Добавляем, что нашли единицу в i-ой строке.
                    count[table.length + j] += 1; //Добавляем, что нашли единицу в j-ой столбце.
                }
            }
        }
        //Сверяем количество единиц в столбцах и строках с нужным количеством.
        for (int i = 0; i != count.length; i++){
            if (count[i] == table.length) {
                result = true;
                break;
            }
        }
        return result;
    }*/

    //Второй вариант isWin().
    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        //Подсчитываем количество единиц в i-ой строке.
        //В lastColumn хранится индекс столбца, в котором была найдена последняя единица.
        for (int i = 0, countInLine = 0, lastColumn = 0; i != table.length; i++, countInLine=0) {
            for (int j = 0; j != table.length; j++) {
                if (table[i][j] == 1) {
                    countInLine += 1;
                    lastColumn = j;
                }
            }
            //Если в i-ой строке все единицы, то выводим true.
            if (countInLine == table.length) {
                result = true;
                break;
            }
            //Если в i-ой строке больше одной единицы, то выводим false(дальше нет смысла проверять).
            else if (countInLine > 1) {
                result = false;
                break;
            }
            //Если в i-ой строке одна единица, то проверяем только этот столбец где найдена эта единица.
            else if (countInLine == 1) {
                result = true;
                //Если в столбце не все единицы, то выводим false.
                for (int k = 0; k != table.length; k++) {
                    if (table[k][lastColumn] != 1) {
                        result = false;
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
