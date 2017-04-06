#pragma once

#include <iostream>
#include <string.h>
#include <list>
#include <iomanip>

using namespace std;

struct statement {
    virtual void print(int indent) = 0;
};
struct programm {
    list<statement *> *stmts;
    programm(list<statement *> *other)
            : stmts(other)
        {}
    void print() {
        list<statement *>::iterator stmtIter;
        for (stmtIter = stmts->begin(); stmtIter != stmts->end();
               stmtIter++) {
            (*stmtIter)->print(0);
        }
        cout << endl;
    }
};

struct exp_node {
    virtual void print(int indent) = 0;
};

struct number_node : public exp_node {
    double num;
    number_node(double value)
        : num(value)
    {}

    void print(int indent) {
        cout << setw(indent) << num;
    }

};

struct id_node : public exp_node {
    string id;
    id_node(char* value)
        : id(value)
    {}

    void print(int indent) {
        cout << setw(indent) << id;
    }
};

struct operation_node : public exp_node {
    exp_node *left;
    exp_node *right;

    operation_node(exp_node *l, exp_node *r)
        : left(l)
        , right(r)
    {}

    void print(int indent) {
        left->print(indent + 4);
        cout << endl;
        right->print(indent + 4);
    }
};

struct plus_node : public operation_node {
    plus_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "+\n";
        operation_node::print(indent + 4);
    }
};

struct minus_node : public operation_node {
    minus_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "-\n";
        operation_node::print(indent + 4);
    }
};

struct mult_node : public operation_node {
    mult_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "*\n";
        operation_node::print(indent + 4);
    }
};

struct divide_node : public operation_node {
    divide_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "/\n";
        operation_node::print(indent + 4);
    }
};

struct mod_node : public operation_node {
    mod_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "%\n";
        operation_node::print(indent + 4);
    }
};

struct equal_node : public operation_node {
    equal_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "==\n";
        operation_node::print(indent + 4);
    }
};

struct neq_node : public operation_node {
    neq_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "!=\n";
        operation_node::print(indent + 4);
    }
};

struct gt_node : public operation_node {
    gt_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << ">\n";
        operation_node::print(indent + 4);
    }
};

struct ge_node : public operation_node {
    ge_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << ">=\n";
        operation_node::print(indent + 4);
    }
};

struct lt_node : public operation_node {
    lt_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "<\n";
        operation_node::print(indent + 4);
    }
};

struct le_node : public operation_node {
    le_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "<=\n";
        operation_node::print(indent + 4);
    }
};

struct and_node : public operation_node {
    and_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "&&\n";
        operation_node::print(indent + 4);
    }
};

struct or_node : public operation_node {
    or_node(exp_node *l, exp_node *r)
        : operation_node(l, r)
    {}

    void print(int indent) {
        cout << setw(indent) << "||\n";
        operation_node::print(indent + 4);
    }
};


struct skip_statement : statement {
    void print(int indent) {
        cout << "skip";
    }
};

struct assign_statement : statement {
    std::string ident;
    exp_node *exp;
    assign_statement(char* l, exp_node *r)
        : ident(l)
        , exp(r)
    {}
    void print(int indent) {
        cout << setw(indent) << "=";
        cout << std::setw(indent + 4) << ident;
        exp->print(indent + 4);
    }
};

struct colon_statement : statement {
    statement *left;
    statement *right;
    colon_statement(statement *l, statement *r)
        : left(l)
        , right(r)
    {}
    void print(int indent) {
        cout << setw(indent) << ";";
        left->print(indent + 4);
        right->print(indent + 4);
    }
};

struct read_statement : statement {
    std::string ident;
    read_statement(char *id)
        : ident(id)
    {}
    void print(int indent) {
        cout << setw(indent) << "read\n";
        cout << std::setw(indent + 4) << ident;
    }
};

struct write_statement : statement {
    exp_node * exp;
    write_statement(exp_node *other)
        : exp(other)
    {}
    void print(int indent) {
        cout << setw(indent) << "write\n";
        exp->print(indent + 4);
    }
};

// struct do_statement : statement {
//     statement *do_;
//     do_statement(statement *other)
//         : do_(other)
//     {}
//     void print(int indent) {
//         cout << "do\n";
//         do_->print(indent + 4);
//     }
// };

struct while_statement : statement {
    exp_node *cond;
    statement *body;
    while_statement(exp_node *other_cond, statement *body_other)
        : cond(other_cond)
        , body(body_other)
    {}
    void print(int indent) {
        cout << setw(indent) << "while\n";
        cond->print(indent + 4);
        cout << endl;
        body->print(indent + 4);
    }
};

// struct then_statement : statement {
//     statement *statement_;
//     then_statement(statement *other)
//         : statement_(other)
//     {}

//     void print(int indent) {
//         cout << "then\n";
//         statement_->print(indent + 4);
//     }
// };

// struct else_statement : statement {
//     statement *statement_;
//     else_statement(statement *other)
//         : statement_(other)
//     {}

//     void print(int indent) {
//         cout << "else\n";
//         statement_->print(indent + 4);
//     }
// };

struct if_statement : statement {
    exp_node *cond;
    statement *then_;
    statement *else_;
    if_statement(exp_node *cond_other,
                 statement *then_other,
                 statement *else_other)
        : cond(cond_other)
        , then_(then_other)
        , else_(else_other)
    {}

    void print(int indent) {
        cout << setw(indent) << "if\n";
        cond->print(indent + 4);
        cout << endl;
        then_->print(indent + 4);
        cout << endl;
        else_->print(indent + 4);
    }
};


