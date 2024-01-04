#include <iostream>

using namespace std;

/*
    1, 2, 3
    hash
*/

class Node {
public:
    int key;
    int value;
    Node* next;
    

    Node(): key(key) value(value) {}
};

class MyHashMap {
private:
    int size;
    double ratio = 0.75;
    Node** bucket;
    int total = 0;

public:
    MyHashMap(): size(100) {
        this->bucket[this->size] = {};
    }

    MyHashMap(int size) {
        this->size = size;
        this->bucket[size] = {};
    }

    void put(int key, int value) {
        int val = getValue(key);
        Node* node;
        if (this->bucket[val] == nullptr) {
            node = new Node(key, value);
        } else {
            Node* cur = this->bucket[val];
            while (cur) {
                if (cur->key == key) {
                    break;
                }
                cur = cur->next;
            }
            if (cur == nullptr) {
                node = new Node(key, value);
            } else {
                cur->value = value;
                return;
            }
        }
        node->next = this->bucket[val];
        this->bucket[val] = node;
    }

    int get(int key) {
        int val = getValue(key);
        Node* node = this->bucket[val];
        while (node != nullptr) {
            if (node->key == key) {
                return node->value;
            } 
            node = node->next;
        }
        
        return -1;
    }   

    void remove(int key) {
        int val = getValue(key);
        Node* node = this->bucket[val];
        Node* prev = nullptr;
        while (node != nullptr) {
            if (node->key == key) {
                break;
            }
            prev = node;
            node = node->next;
        }
        if (node == nullptr) {
            return;
        }
        if (prev == nullptr) {
            Node* toDelete = this->bucket[val];
            this->bucket[val] = this->bucket[val]->next;
            delete toDelete;
        } else {
            prev->next = prev->next->next;
            delete node;
        }
        return;
    }

private:
    /*
        directly use key as hashcode
    */
    int getValue(int key) {
        return key % this->size;
    }

    void rehash() {
        if (total <= ratio * this->size) {
            return;
        }
        Node** newBucket;

    }
};

int main(int argc, char** argv) {
    MyHashMap myHashMap;

    return 0;
}

