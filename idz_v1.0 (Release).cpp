#include <iostream>
#include <cmath>

class Matrix
{
    private:

        int arrColumn; //m
        int arrRows; //n
        int **arr;

        int error; // 0 - все ок, 1 - память не выделена, 2 - матрица пуста

    public:

        //конструкторы
        Matrix();
        Matrix(int n, int m);

        //конструктор копирования
        Matrix(const Matrix &M);

        //деструктор
        ~Matrix();

        void read(); //запись в массив
        void print(); //вывод массива

        void sort(); //сортировка

        int getError() const; //ошибки
};

Matrix::Matrix()
{
    arrRows = 0;
    arrColumn = 0;
    arr = NULL;
}

Matrix::Matrix(int n, int m) //задаю размер
{
    arrRows = n;
    arrColumn = m;

    arr = new int* [arrRows];
    for (int i = 0; i < arrRows; i++)
    {
        arr[i] = new int [arrColumn];
    }
}

Matrix::Matrix(const Matrix &M)
{
    arrRows = M.arrRows;
    arrColumn = M.arrColumn;

    arr = new int* [arrRows];
    for (int i = 0; i < arrRows; i++)
    {
        arr[i] = new int [arrColumn];
    }

    for (int i = 0; i < arrRows; i++)
    {
        for (int j = 0; j < arrColumn; j++)
        {
            arr[i][j] = M.arr[i][j];
        }
    }
}

Matrix::~Matrix()
{
    if (arr != NULL)
    {
        for (int i = 0; i < arrRows; i++)
        {
            delete[] arr[i];
        }
        delete[] arr;
    }
}

void Matrix::read()
{
    if (arr == NULL)
    {
        std::cout << "Память не выделена " << std::endl;

        error = 1;
    }

    std::cout << "Введите матрицу: " << std::endl;

    for (int i = 0; i < arrRows; i++)
    {
        for (int j = 0; j < arrColumn; j++)
        {
            std::cin >> arr[i][j];
        }
    }

    error = 0;
}

void Matrix::print()
{
    if (arr == NULL)
    {
        std::cout << "Матрица пустая! " << std::endl;

        error = 2;
    }

    std::cout << "Матрица: " << std::endl;

    for (int i = 0; i < arrRows; i++)
    {
        for (int j = 0; j < arrColumn; j++)
        {
            std::cout << arr[i][j] << " ";
        }
        std::cout << std::endl;
    }

    error = 0;
}

void Matrix::sort()
{
    int *arrSum = new int[arrRows]; // массив в котором будем запоминать сумму строк

    for(int i = 0; i < arrRows; i++)
    {
        int sum = 0;
        arrSum[i] = 0;
        for (int j = 0; j < arrColumn; j++)
        {
            sum += arr[i][j];
        }
        arrSum[i] = abs(sum);
    }

    for(int i = 1; i < arrRows; i++) //сравнить следующий с предыдущим
    {
        int* a; //переменная в которую мы запоминаем индексы строк
        int indexSum;

        int index = i - 1;
        // arrSum[index] - нулевой элемент arrSum[index + 1] - следующий элемент при i = 1;
        while(arrSum[index + 1] < arrSum[index] && index >= 0)
        {
            // меняет указатели строк
            a = arr[index]; // сохраняем текущий элемент массива в а меняем местами индексы массива
            arr[index] = arr[index + 1];
            arr[index + 1] = a;

            indexSum = arrSum[index]; // меняем местами элементы в массиве arrSum
            arrSum[index] = arrSum[index + 1];
            arrSum[index + 1] = indexSum;

            index--;
        }
    }
    std::cout << "Отсортированная матрица: " << std::endl;

    for (int i = 0; i < arrRows; i++)
    {
        for (int j = 0; j < arrColumn; j++)
        {
            std::cout << arr[i][j] << " ";
        }
        std::cout << std::endl;
    }
}


int Matrix::getError() const
{
    return error;
}

int main()
{
    int n, m;
    setlocale (LC_ALL, "Russian");
    std::cout << "Введите размер матрицы (n/m): " << std::endl;
    std::cin >> n >> m;
    Matrix Arr(n, m);
    Arr.read();
    Arr.print();
    Arr.sort();
    return 0;
}
