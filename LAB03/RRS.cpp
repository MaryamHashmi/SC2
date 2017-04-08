//
//  main.cpp
//  Lab 3 SC
//
//  Created by misha on 08/03/2017.
//  Copyright © 2017 learn. All rights reserved.
//

#include <iostream>
#include <time.h>
using namespace std;


class table
{
    string type;
    string name;
    bool occupied;
    int persons;
    int time;
    
public:
    table(string Type, int Persons)
    {
        type = Type;
        persons =Persons;
        occupied = false;
    }
    
    void set_name(string Name)
    {
        name=Name;
    }
    
    void set_occupied(bool Occ)
    {
        occupied= Occ;
    }
    
    void set_persons(int Persons)
    {
        persons = Persons;
    }
    
    void set_time(int Time){
        time= Time;
    }
    

    string get_name()
    {
        return name;
    }
    
    bool get_occ()
    {
        return occupied;
    }
    
    int get_persons()
    {
        return persons;
    }
    
    int get_time()
    {
        return time;
    }
};


class node
{
    string name;
    int time;
    int people;
    node* next;
    
public:
    node()
    {
        name = ' ';
        time = 0;
        people =0;
        next=NULL;
        
    }
   
public:
    node(string Name,int Time,int People, node* Next)
    {
        name =Name;
        time=Time;
        people=People;
        
        next = Next;
    }

    
    void set_name(string Name)
    {
        name=Name;
    }
    void set_time(int Time)
    {
        time=Time;
    }
    void set_people(int People)
    {
        people=People;
    }
    void set_next(node* Next)
    {
        next=Next;
    }
    
    string get_name()
    {
        return name;
    }
    int get_time()
    {
        return time;
    }
    int get_people()
    {
        return people;
    }
    node* get_node()
    {
        return next;
    }
};



class XLtable{
    
    node *head;
    node *tail;
    node *prev;
    
public:
    XLtable()
    {
        head=NULL;
        tail=NULL;
        prev=NULL;
    }
    
    void reserve(string Name, int Time, int People)
    {
        node *temp = new node(Name, Time, People, NULL);
        if (head==NULL)
        {
            head=temp;
            tail=temp;
            head->set_next(NULL);
        }
        else{
            tail->set_next(temp);
            tail=temp;
            tail->set_next(NULL);
        }
    }
    
    void remove_res(string Name)
    {
        if(head==NULL)
        {
            cout<<"List is empty. \n";
        }
        else
        {
            node* temp=head;
            prev=head;
            
            while(temp!=NULL)
            {
                if(temp->get_name()==Name)
                {
                    if(temp==head)
                        head=temp->get_node();
                    else if(temp->get_node()!=NULL)
                        prev->set_next(temp->get_node());
                    else if(temp->get_node()==NULL)
                    {
                        prev->set_next(NULL);
                        tail=prev;
                    }
                    
                    
                }
                prev=temp;
                temp=temp->get_node();
            }
        }
        
    }
    
    
    void print_res()
    {
        node *temp=head;
        while(temp!=NULL)
        {
            cout<<temp->get_node()<<"\n";
            temp=temp->get_node();
        }
    }
    
    
    bool check_avail(int Time)
    {
        XLtable *one= new XLtable;
        time_t t;
        node*temp=head;
        while(temp!=NULL)
        {
            if(time(&t)>temp->get_time())
            {
                one->remove_res(temp->get_name());
            }
            temp=temp->get_node();
        }
        temp = head;
        while(temp!=NULL)
        {
            if(temp->get_time()==t)
            {
                cout<<"No reservation avail.\n";
                return false;
            }
            temp=temp->get_node();
        }
        return true;
    }

    
};


class Ltable{
        
        node *head;
        node *tail;
        node *prev;
        
        public:
        Ltable()
        {
            head=NULL;
            tail=NULL;
            prev=NULL;
        }
        
        void reserve(string Name, int Time, int People)
        {
            node *temp = new node(Name, Time, People, NULL);
            if (head==NULL)
            {
                head=temp;
                tail=temp;
                head->set_next(NULL);
            }
            else{
                tail->set_next(temp);
                tail=temp;
                tail->set_next(NULL);
            }
        }
        
        void remove_res(string Name)
        {
            if(head==NULL)
            {
                cout<<"List is empty. \n";
            }
            else
            {
                node* temp=head;
                prev=head;
                
                while(temp!=NULL)
                {
                    if(temp->get_name()==Name)
                    {
                        if(temp==head)
                        head=temp->get_node();
                        else if(temp->get_node()!=NULL)
                        prev->set_next(temp->get_node());
                        else if(temp->get_node()==NULL)
                        {
                            prev->set_next(NULL);
                            tail=prev;
                        }
                        
                        
                    }
                    prev=temp;
                    temp=temp->get_node();
                }
            }
            
        }
        
        
        void print_res()
        {
            node *temp=head;
            while(temp!=NULL)
            {
                cout<<temp->get_node()<<"\n";
                temp=temp->get_node();
            }
        }
        
        
        bool check_avail(int Time)
        {
            Ltable *one= new Ltable;
            time_t t;
            node*temp=head;
            while(temp!=NULL)
            {
                if(time(&t)>temp->get_time())
                {
                    one->remove_res(temp->get_name());
                }
                temp=temp->get_node();
            }
            temp = head;
            while(temp!=NULL)
            {
                if(temp->get_time()==t)
                {
                    cout<<"No reservation avail.\n";
                    return false;
                }
                temp=temp->get_node();
            }
            return true;
        }
        
        
    
};


class Mtable{
    
    node *head;
    node *tail;
    node *prev;
    
    public:
    Mtable()
    {
        head=NULL;
        tail=NULL;
        prev=NULL;
    }
    
    void reserve(string Name, int Time, int People)
    {
        node *temp = new node(Name, Time, People, NULL);
        if (head==NULL)
        {
            head=temp;
            tail=temp;
            head->set_next(NULL);
        }
        else{
            tail->set_next(temp);
            tail=temp;
            tail->set_next(NULL);
        }
    }
    
    void remove_res(string Name)
    {
        if(head==NULL)
        {
            cout<<"List is empty. \n";
        }
        else
        {
            node* temp=head;
            prev=head;
            
            while(temp!=NULL)
            {
                if(temp->get_name()==Name)
                {
                    if(temp==head)
                    head=temp->get_node();
                    else if(temp->get_node()!=NULL)
                    prev->set_next(temp->get_node());
                    else if(temp->get_node()==NULL)
                    {
                        prev->set_next(NULL);
                        tail=prev;
                    }
                    
                    
                }
                prev=temp;
                temp=temp->get_node();
            }
        }
        
    }
    
    
    void print_res()
    {
        node *temp=head;
        while(temp!=NULL)
        {
            cout<<temp->get_node()<<"\n";
            temp=temp->get_node();
        }
    }
    
    
    bool check_avail(int Time)
    {
        Mtable *one= new Mtable;
        time_t t;
        node*temp=head;
        while(temp!=NULL)
        {
            if(time(&t)>temp->get_time())
            {
                one->remove_res(temp->get_name());
            }
            temp=temp->get_node();
        }
        temp = head;
        while(temp!=NULL)
        {
            if(temp->get_time()==t)
            {
                cout<<"No reservation avail.\n";
                return false;
            }
            temp=temp->get_node();
        }
        return true;
    }
    
    
    
};

class Stable{
    
    node *head;
    node *tail;
    node *prev;
    
    public:
    Stable()
    {
        head=NULL;
        tail=NULL;
        prev=NULL;
    }
    
    void reserve(string Name, int Time, int People)
    {
        node *temp = new node(Name, Time, People, NULL);
        if (head==NULL)
        {
            head=temp;
            tail=temp;
            head->set_next(NULL);
        }
        else{
            tail->set_next(temp);
            tail=temp;
            tail->set_next(NULL);
        }
    }
    
    void remove_res(string Name)
    {
        if(head==NULL)
        {
            cout<<"List is empty. \n";
        }
        else
        {
            node* temp=head;
            prev=head;
            
            while(temp!=NULL)
            {
                if(temp->get_name()==Name)
                {
                    if(temp==head)
                    head=temp->get_node();
                    else if(temp->get_node()!=NULL)
                    prev->set_next(temp->get_node());
                    else if(temp->get_node()==NULL)
                    {
                        prev->set_next(NULL);
                        tail=prev;
                    }
                    
                    
                }
                prev=temp;
                temp=temp->get_node();
            }
        }
        
    }
    
    
    void print_res()
    {
        node *temp=head;
        while(temp!=NULL)
        {
            cout<<temp->get_node()<<"\n";
            temp=temp->get_node();
        }
    }
    
    
    bool check_avail(int Time)
    {
        Stable *one= new Stable;
        time_t t;
        node*temp=head;
        while(temp!=NULL)
        {
            if(time(&t)>temp->get_time())
            {
                one->remove_res(temp->get_name());
            }
            temp=temp->get_node();
        }
        temp = head;
        while(temp!=NULL)
        {
            if(temp->get_time()==t)
            {
                cout<<"No reservation avail.\n";
                return false;
            }
            temp=temp->get_node();
        }
        return true;
    }
    
    
    
};




class check_availability {
    table checkAvailability(string name,int persons,int time, table t1,table t2,table t3,table t4,table t5,table t6,table t7,table t8,table t9,table t10,table t11,table t12,table t13,table t14,table t15,table t16)
    {
        if(persons<=2)
        {
            if(time!=t13.get_time())
            {
                
            }
        }
        else if(persons<=4)
        {
            
        }
        else if(persons<=6)
        {
            
        }
        else if(persons<=12)
        {
            
        }
        
        
        table temp=t1;
        return temp;
    }
};





int main() {
    
    
    int choice;
    int choice2;
    
    XLtable *e= new XLtable();
    Ltable *l= new Ltable();
    Mtable *m= new Mtable();
    Stable *s= new Stable();
    
    
    cout<<"1- Customer\n";
    cout<<"2- Admin\n";
    
    cin>>choice;
    
    while(true)
    {
        switch(choice)
        {
            case 1:
            
            cout<<"1- Make a reservation\n";
            cout<<"2- Check your reservation\n";
            cin>>choice2;
            switch(choice2)
            {
            case 1:
                {
                int people;
                string name;
                int time;
                bool av=false;
                
                cout<<"For how many people do you want to make the reservation?";
                cin>>people;
                
                cout<<"For what time do you want make the reservation?\n";
                cin>>time;
                
                if(people<=2)
                    av=s->check_avail(time);
                else if(people<=4)
                    av=m->check_avail(time);
                else if(people<=6)
                    av=l->check_avail(time);
                else if(people<=12)
                {
                    
                    av=e->check_avail(time);
                    
                }
                if(av==false)
                {
                    cout<<"Sorry all the tables are occupied. Try another time.\n";
                    break;
                }
                
                cout<<"By which name do you want to make the reservation?\n";
                cin>>name;
                if(people<=2)
                    s->reserve(name, time, people);
                else if(people<=4)
                    m->reserve(name, time, people);
                else if(people<=6)
                    l->reserve(name, time, people);
                else if(people<=12)
                    e->reserve(name, time, people);
                cout<<"Congratulations your reservation has been made for "<<time<<":00 hours today.\n";
                
                break;
                }
            case 2:
                break;
                
            }
            break;
            
            case 2:
            
            {
            string password="admin";
            int choice3;
            
            cout<<"Enter the password\n";
            string npass;
            cin>>npass;
            
            while(npass!=password){
                cout<<"Wrong password. Please try again.\n";
                cin>>npass;
            }
                
            
            
            cout<<"Login Successful\n";
            cout<<"1- View all reservations\n";
            cin>>choice3;
            switch(choice3)
            {
                case 1:
                cout<<"For Extra Large Table: ";
                e->print_res();
                
                cout<<"\nFor Large Table: ";
                l->print_res();
                cout<<"\nFor Medium Table: ";
                m->print_res();
                cout<<"\nFor Small Table: ";
                s->print_res();
                break;
                
            }
            
            break;
        }
        cout<<"\n\n";
        cout<<"1- Customer\n";
        cout<<"2- Admin\n";
        cin>>choice;
        
        
    }
    
}
}
