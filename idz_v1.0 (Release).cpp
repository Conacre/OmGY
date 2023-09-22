#include <iostream>
#include <cmath>

class Matrix
{
    private:

        int arrColumn; //m
        int arrRows; //n
        int **arr;

        int error; // 0 - ��� ��, 1 - ������ �� ��������, 2 - ������� �����

    public:

        //������������
        Matrix();
        Matrix(int n, int m);

        //����������� �����������
        Matrix(const Matrix &M);

        //����������
        ~Matrix();

        void read(); //������ � ������
        void print(); //����� �������

        void sort(); //����������

        int getError() const; //������
};

Matrix::Matrix()
{
    arrRows = 0;
    arrColumn = 0;
    arr = NULL;
}

Matrix::Matrix(int n, int m) //����� ������
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
        std::cout << "������ �� �������� " << std::endl;

        error = 1;
    }

    std::cout << "������� �������: " << std::endl;

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
        std::cout << "������� ������! " << std::endl;

        error = 2;
    }

    std::cout << "�������: " << std::endl;

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
    int *arrSum = new int[arrRows]; // ������ � ������� ����� ���������� ����� �����

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

    for(int i = 1; i < arrRows; i++) //�������� ��������� � ����������
    {
        int* a; //���������� � ������� �� ���������� ������� �����
        int indexSum;

        int index = i - 1;
        // arrSum[index] - ������� ������� arrSum[index + 1] - ��������� ������� ��� i = 1;
        while(arrSum[index + 1] < arrSum[index] && index >= 0)
        {
            // ������ ��������� �����
            a = arr[index]; // ��������� ������� ������� ������� � � ������ ������� ������� �������
            arr[index] = arr[index + 1];
            arr[index + 1] = a;

            indexSum = arrSum[index]; // ������ ������� �������� � ������� arrSum
            arrSum[index] = arrSum[index + 1];
            arrSum[index + 1] = indexSum;

            index--;
        }
    }
    std::cout << "��������������� �������: " << std::endl;

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
    std::cout << "������� ������ ������� (n/m): " << std::endl;
    std::cin >> n >> m;
    Matrix Arr(n, m);
    Arr.read();
    Arr.print();
    Arr.sort();
    return 0;
}
