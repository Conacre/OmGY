#include <iostream>
#include <fstream>

struct node
{
    char data;
    node *next;
};

class StackList
{
    private:
        node *top_ptr; //ссылочка на самый главный элем
        void fail(int); //ошибка

    public:
        StackList(); //конструктор
        StackList(const StackList&); //конструктор копирования
        ~StackList(); //деструктор
        double top(); //посмотреть вершину
        void pop(); //удалить вершину
        void push(char value); //положить в вершину
        bool empty(); //проверка на пустоту
        friend void print(const StackList&); //вывод на экран
};

void StackList::fail(int err)
{
    switch (err)
    {
        case 1:
            std::cout << "Не хватает памяти!\n";
            break;
        case 2:
            std::cout << "Стек пуст!\n";
            break;
    }
    exit(1);
}

StackList::StackList()
{
    top_ptr = nullptr;
}

StackList::StackList(const StackList &st)
{
    if (st.top_ptr == nullptr)
        {
            top_ptr = nullptr;
        }
        else
        {
            top_ptr = new node{st.top_ptr -> data, nullptr};
            node* curr = top_ptr;
            node* stCurr = st.top_ptr -> next;
            while (stCurr != nullptr)
            {
                curr -> next = new node{stCurr -> data, nullptr};
                curr = curr -> next;
                stCurr = stCurr -> next;
            }
        }
}

StackList::~StackList()
{
    node *tmp = nullptr;
    while(!empty())
    {
        tmp = top_ptr;
        top_ptr = top_ptr -> next;
        delete[] tmp;
        tmp = nullptr;
    }
}

bool StackList::empty()
{
    return top_ptr == nullptr;
}

double StackList::top()
{
    if(!empty()) return top_ptr -> data;
    else fail(2);
}

void StackList::pop()
{
    if(empty()) fail(2);
    else
    {
        node *tmp = top_ptr;
        top_ptr = top_ptr -> next;
        delete tmp;
        tmp = nullptr;
    }
}

void StackList::push(char value)
{
    node *top = nullptr;
    top = new (std::nothrow) node;
    if(top == nullptr) fail(1);
    else
    {
        top -> data = value;
        top -> next = top_ptr;
        top_ptr = top;
    }
}

void print(const StackList &st)
{
    node *iterator = st.top_ptr;
    while (iterator != nullptr)
    {
        std::cout << iterator -> data << " ";
        iterator = iterator -> next;
    }
}

void reverseStack(StackList &st1, char a)
{
    StackList tmp(st1);
    char value;
    while (!st1.empty())
    {
        st1.pop();
    }
    while (!tmp.empty())
    {
        value = tmp.top();
        if (value == a)
        {
            st1.push('"');
            st1.push(value);
            st1.push('"');
            tmp.pop();
        }
        else
        {
            st1.push(value);
            tmp.pop();
        }
    }
    std::cout << "Готовый стек: " << std::endl;
    print(st1);
}


int main()
{
    setlocale(LC_ALL, "Russian");
    std::ifstream fin;
    char n, symbol;
    std::string nameTest;
    std::cout << "Введите название теста: " << std::endl;
    std::cin >> nameTest;
    fin.open(nameTest);

    if(!fin.is_open())
    {
        std::cout << "Не удалось открыть файл! ";
    }
    else
    {
        std::cout << "Введите необходимый символ: " << std::endl;
        std::cin >> symbol;
        StackList st1;

        while(fin >> n)
        {
            st1.push(n);
        }
        std::cout << "Исходный стек: " << std::endl;
        print(st1);
        std::cout << std::endl;
        reverseStack(st1, symbol);
    }
}
