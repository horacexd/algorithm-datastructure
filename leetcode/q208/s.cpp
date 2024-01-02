#include <iostream>
#include <string>

using namespace std;

class TrieNode {
public:
    TrieNode* children[26] = {};
    bool isValue;
    
    TrieNode() : isValue(false) {}
};

class Trie {

private:
    TrieNode* _root;

public:
    Trie() {
        this->_root = new TrieNode();
    }

    void insert(string word) {
        TrieNode* cur = this->_root;
        for (char c : word) {
            int pos = c - 'a';
            if (cur->children[pos] == nullptr) {
                cur->children[pos] = new TrieNode();
            } 
            cur = cur->children[pos];
        }
        cur->isValue = true;
    }

    bool search(string word) {
        TrieNode* cur = this->_root;
        for (char c : word) {
            int pos = c - 'a';
            if (cur->children[pos] == nullptr) {
                return false;
                
            }
            cur = cur->children[pos];
        }
        return cur->isValue;
    }

    bool startsWith(string prefix) {
        TrieNode* cur = this->_root;
        for (char c : prefix) {
            int pos = c - 'a';
            if (cur->children[pos] == nullptr) {
                return false;    
            }
            cur = cur->children[pos];
        }
        return true;
    }
};

int main(int argc, char** argv) {

    Trie trie;
    trie.insert("abandon");
    trie.insert("abort");
    trie.insert("wisdom");
    trie.insert("");
    cout << trie.search("abort") << endl;
    cout << trie.search("apple") << endl;
    cout << trie.startsWith("ab") << endl;
    cout << trie.startsWith("wisdom") << endl;
    cout << trie.startsWith("") << endl;

    return 0;
}