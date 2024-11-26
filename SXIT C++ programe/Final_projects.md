# Shanxi Institute of Technology "C++ Programming" Course Design Report
## Perface
According to the development requirements, this system is mainly used in the education system to complete the digital management of student performance files in daily educational work. The development of this system can reduce the work pressure of college faculty and staff, and more systematically manage various services and information on academic affairs and teaching. At the same time, it can reduce the use of labor, speed up inquiries, strengthen management, and improve the management of various national departments. The pace of informatization has made various managements more standardized.<br>

During the development process of this system, attention was paid to making it conform to the operational business process, and efforts were made to make the system comprehensive and universal, so that this system is not only suitable for one school. During development, we conducted four main stages of system investigation and research, system analysis, system design and system implementation. In terms of specific design, we adopted an evolutionary prototyping method. As users use and understand the system, we Continue to deepen and reanalyze, design, and implement a certain part or parts.<br>

<b>Keywords:</b> C/C++; student information management system; multi-function; automated management, linked list, Data Structures and Algorithms;

## Functuion
1. Student information entry: The student's basic information (such as name, class, student number, etc.) is completed in the data field of the new node through operations such as linked lists and new nodes, and the pointer field points to the next node. to establish links with other data.

2. Browse student information: Through the establishment of linked lists and operations on the linked lists, complete operations such as "query by student number", "query by class", "query by name", "statistics of class numbers" and "statistics of provinces".

3. To modify student information, find the corresponding data location on the linked list, and then modify the relevant data in the data field.

4. To delete student information, find the data you want to delete through linked list operations, first change the relationship between the preceding and following nodes, and then delete the node.

5. Sorting student information: Arrange the elements of the structure in ascending and descending order by calling the functions void sortUp(struct Node* headNode) and void sortDrop (struct Node* headNode), in which an algorithm is used to sort the data and then output.

6. Student information statistics: Check and count the contents of the structure element data.addr to achieve statistical results of "statistics by province" and "statistics by class".

7. File saving: Use the function void writeInFromFile(struct Node* headNode,char* filename) to perform file reading and writing operations, so that the file can be saved in a specific txt document, so that the results can be saved for a long time.

## HeadFile
```cpp
#include <bits/stdc++.h>
```
## Class
```cpp
class Student{
public:
	friend void Input(Student stu[]);
	friend void Statistic(Student stu[]);
	friend void Lookup(Student stu[]);
	friend void Modify(Student stu[]);
	friend void Delete(Student stu[]);
	friend void Output(Student stu[]);
	friend void Insert(Student stu[]);
	friend void Sort(Student stu[]);
	friend void Write(Student stu[],int n);
	friend int Read(Student stu[]);
private:
	int num;
	char name[8];
	char class_0[20];
	float elec;
	float c_program;
	float english;
	float math;
	float media;
	float sport;
	float polity;
	float average;
	int order;
}stu[100];
```
## File I/O
```cpp
void Write(Student stu[], int n) {
	fstream myFile;
	myFile.open("score.txt", ios::out | ios::binary);
	if (!myFile) {
		cout << "score.txt can't open!" << endl;
		abort();
	}
	int count = n;
	myFile << count << endl<<endl;
	for (int i = 0; i < count; i++) {
		myFile << stu[i].class_0  << "\t"
			   << stu[i].num      << "\t"
			   << stu[i].name     << "\t"
			   << stu[i].elec     << "\t"
			   << stu[i].c_program<< "\t"
			   << stu[i].media    << "\t"
			   << stu[i].english  << "\t"
			   << stu[i].math     << "\t"
			   << stu[i].sport    << "\t"
			   << stu[i].polity   << "\t"
			   << stu[i].average  << endl;
	}
	myFile.close();
}
 
int Read(Student stu[]) {
	fstream myFile;
	myFile.open("score.txt", ios::in | ios::binary);
	if (!myFile) {
		cout << "score.txt can't open!" << endl;
		abort();
	}
	int count;
	myFile.seekg(0);
	myFile >> count;
	for (int i = 0; i <= count; i++) {
		myFile >> stu[i].class_0 >> stu[i].num       >> stu[i].name 
			   >> stu[i].elec    >> stu[i].c_program >> stu[i].media 
			   >> stu[i].english >> stu[i].math      >> stu[i].sport 
			   >> stu[i].polity  >> stu[i].average;
	}
	myFile.close();
	return count;
}
```

## Algorithm
### Bubble_Sort
```cpp
void Sort(Student stu[]) {
	system("cls");
	int i, j, k;
	float s;
	char t[20];
	cout << endl << "======>>    降序排列    <<======" << endl;
	int n = Read(stu);
	for (i = 0; i < n-1; i++) {
		for (j = 0; j < n - 1; j++) {
			if (stu[j].average < stu[j + 1].average) {
                
				strcpy(t, stu[j + 1].class_0);
				strcpy(stu[j + 1].class_0, stu[j].class_0);
				strcpy(stu[j].class_0, t);
				//num
				k = stu[j + 1].num;
				stu[j + 1].num = stu[j].num;
				stu[j].num = k;
 
				//name
				strcpy(t, stu[j + 1].name);
				strcpy(stu[j + 1].name, stu[j].name);
				strcpy(stu[j].name, t);
				//elec
				s = stu[j + 1].elec;
				stu[j + 1].elec = stu[j].elec;
				stu[j].elec = s;
				//c_program
				s = stu[j + 1].c_program;
				stu[j + 1].c_program = stu[j].c_program;
				stu[j].c_program = s;
				//media
				s = stu[j + 1].media;
				stu[j + 1].media = stu[j].media;
				stu[j].media = s;
				//english
				s = stu[j + 1].english;
				stu[j + 1].english = stu[j].english;
				stu[j].english = s;
				//math
				s = stu[j + 1].math;
				stu[j + 1].math = stu[j].math;
				stu[j].math = s;
				//sport
				s = stu[j + 1].sport;
				stu[j + 1].sport = stu[j].sport;
				stu[j].sport = s;
				//polity
				s = stu[j + 1].polity;
				stu[j + 1].polity = stu[j].polity;
				stu[j].polity = s;
				//average
				s = stu[j + 1].average;
				stu[j + 1].average = stu[j].average;
				stu[j].average = s;
			}
		}
	}
	cout << "------------------------------------------------------------------------------------" << endl;
	cout << "班级" << "\t" << "学号" << "\t" << "姓名" << "\t"
		 << "电子" << "\t" << "C++" << "\t" << "多媒体" << "\t"
		 << "英语" << "\t" << "数学" << "\t" << "体育" << "\t"
		 << "政治" << "\t" << "平均分" << endl;
	cout << "------------------------------------------------------------------------------------" << endl;
	for (int i = 0; i < n; i++) {
		stu[i].order = i + 1;
		cout << stu[i].class_0 << "\t" << stu[i].num       << "\t" << stu[i].name << "\t"
			 << stu[i].elec    << "\t" << stu[i].c_program << "\t" << stu[i].media << "\t"
			 << stu[i].english << "\t" << stu[i].math      << "\t" << stu[i].sport << "\t"
			 << stu[i].polity  << "\t" << stu[i].average   << endl;
	}
	Write(stu, n);
}
```

## Development Environment

<b>Visual Studio Code</b>, also commonly referred to as VS Code,is an integrated development environment developed by Microsoft for Windows, Linux, macOS and web browsers. Features include support for debugging, syntax highlighting, intelligent code completion, snippets, code refactoring, and embedded version control with Git. Users can change the theme, keyboard shortcuts, preferences, and install extensions that add functionality.

Visual Studio Code is proprietary software released under the "Microsoft Software License", but based on the MIT licensed program named "Visual Studio Code — Open Source" (also known as "Code — OSS"), also created by Microsoft and available through GitHub.

In the Stack Overflow 2023 Developer Survey, Visual Studio Code was ranked the most popular developer environment tool among 86,544 respondents, with 73.71% reporting that they use it.