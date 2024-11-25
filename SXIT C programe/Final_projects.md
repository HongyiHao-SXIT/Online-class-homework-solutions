# Shanxi Institute of Technology "Fundamentals of Programming" Course Design Report
## Perface
According to the development requirements, this system is mainly used in the education system to complete the digital management of student performance files in daily educational work. The development of this system can reduce the work pressure of college faculty and staff, and more systematically manage various services and information on academic affairs and teaching. At the same time, it can reduce the use of labor, speed up inquiries, strengthen management, and improve the management of various national departments. The pace of informatization has made various managements more standardized.<br>

During the development process of this system, attention was paid to making it conform to the operational business process, and efforts were made to make the system comprehensive and universal, so that this system is not only suitable for one school. During development, we conducted four main stages of system investigation and research, system analysis, system design and system implementation. In terms of specific design, we adopted an evolutionary prototyping method. As users use and understand the system, we Continue to deepen and reanalyze, design, and implement a certain part or parts.<br>

<b>Keywords:</b> C/C++; student information management system; multi-function; automated management, linked list;

## Functuion
1. Student information entry: The student's basic information (such as name, class, student number, etc.) is completed in the data field of the new node through operations such as linked lists and new nodes, and the pointer field points to the next node. to establish links with other data.

2. Browse student information: Through the establishment of linked lists and operations on the linked lists, complete operations such as "query by student number", "query by class", "query by name", "statistics of class numbers" and "statistics of provinces".

3. To modify student information, find the corresponding data location on the linked list, and then modify the relevant data in the data field.

4. To delete student information, find the data you want to delete through linked list operations, first change the relationship between the preceding and following nodes, and then delete the node.

5. Sorting student information: Arrange the elements of the structure in ascending and descending order by calling the functions void sortUp(struct Node* headNode) and void sortDrop (struct Node* headNode), in which an algorithm is used to sort the data and then output.

6. Student information statistics: Check and count the contents of the structure element data.addr to achieve statistical results of "statistics by province" and "statistics by class".

7. File saving: Use the function void writeInFromFile(struct Node* headNode,char* filename) to perform file reading and writing operations, so that the file can be saved in a specific txt document, so that the results can be saved for a long time.

## Algorithm
### Sort algorithm
```c
void sortUp(struct Node* headNode){
    struct Node* turn;
    struct Node* move;
    struct student temp;
    for(turn = headNode -> next;turn -> next != NULL;turn = turn -> next){
        for(move = headNode -> next;move -> next != NULL;move = move -> next){
            if(move -> data.num > move -> next -> data.num){
                temp = move -> data;
                move -> data = move -> next -> data;
                move -> next -> data = temp;
            }
        }
    }
    printList(list);
}

void sortDrop(struct Node* headNode){
    struct Node* turn;
    struct Node* move;
    struct student temp;
    for(turn = headNode -> next;turn -> next != NULL;turn = turn -> next){
        for(move = headNode -> next;move -> next != NULL;move = move -> next){
            if(move -> data.num < move -> next -> data.num){
                temp = move -> data;
                move -> data = move -> next -> data;
                move -> next -> data = temp;
            }
        }
    }
    printList(list);
}
```

## Development Environment

<b>Visual Studio Code</b>, also commonly referred to as VS Code,is an integrated development environment developed by Microsoft for Windows, Linux, macOS and web browsers. Features include support for debugging, syntax highlighting, intelligent code completion, snippets, code refactoring, and embedded version control with Git. Users can change the theme, keyboard shortcuts, preferences, and install extensions that add functionality.

Visual Studio Code is proprietary software released under the "Microsoft Software License", but based on the MIT licensed program named "Visual Studio Code — Open Source" (also known as "Code — OSS"), also created by Microsoft and available through GitHub.

In the Stack Overflow 2023 Developer Survey, Visual Studio Code was ranked the most popular developer environment tool among 86,544 respondents, with 73.71% reporting that they use it.