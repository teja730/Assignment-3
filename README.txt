MyHashTableDH 
First of all the information is stored in an array of nodes having two fields, key and object

Insert
using hash function an index is calculated for the key and if the node is not filled the key and object are inserted into it or else the new index is found using second hash function.
worst time complexity-O(n) and average case time O(1)
Update 
same procedure is used to find out the index and if the key of the node at the index matches with the user key then the object is replaced with the new object. finally if the key is not found then it returns -1.
worst time complexity-O(n) and average case time O(1)
Delete
same procedure is used to find out the index of the corresponding key, and if found the node at the corresponding index is reffered to null. and if not found it returns -1.
worst time complexity-O(n) and average case time O(1)
Contains
here linear probing is used to find out the index of the corresponding key, and if found it returns true or else false.
worst time complexity-O(n) and average case time O(1)
Get
same procedure as that of the previous one is used to find out the index of corresponding key, if found it returns the object value inside the node at the index, if not it throws NotFoundException.
worst time complexity-O(n) and average case time O(1)
Address
same procedure as that of the previous one is used to find out the index of corresponding key, if found it returns the index of the value or else it throws the same exception.
worst time complexity-O(n) and average case time O(1)

here I constructed and used a gcd funtion to calculate the no. of times the index can be calculated by adding the second hash function as after a certain limit the indexes would repeat.
i.e.=size/gcd(h2,h2%size) here h2 is index calculated by second hash function. 
Although this wont be helpful here since the hash function is effective and the size of hash table is large enough such that before the repeatition starts the index with the empty node is found, but it would be helpful if the length of hashtable is much large , and also useful for the other functions like update and delete.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
MyHashTableSCBST
Here the hashtable would be array of nodes which has four fields among which two are used to store left and right nodes for binary search tree.
Insert
first of all the index corresponding to the key is calculated. then if first node at the index is empty then key and object are placed there. if not then the key compared with the key at the node if it is greater then it is checked for the right node and left node is checked if it is less. if the node which is checked is empty then the key and the object are inserted in the node, if not the same procedure is repeated again till it finds one of the leaf of the tree.
time complexity-O(logn)
Update
the key compared with the key at the node if it is equal then the obj is updated with new obj, if it is greater then it is checked for the right node and left node is checked if it is less.  if it is equal, then it is updated if not the same procedure is repeated again till it finds the key. if not found till end then it returns -1.
time complexity-O(logn)
Delete
the same procedure is used to find the node corresponding to the key, if found then three cases arise
1.it is leaf
then the node at that point is simply equated to null or deleted.
2.it does not have right child
then the node is simply replaced with child node by replacing all the fields with the fields of the child.
3.it has right child
then the node is replaced with the node of the key which is least in the right sub tree i.e. replaced with the successor, by iterating till the successor and replacing key and obj of the node with that of successor's. if successor had any right child then the successor is replaced with node of its right child or else it is refered to null.
time complexity-O(logn)
Contains
same procedure is followed as that of the previous one to locate the key, if not found then it returns false else true.
time complexity-O(logn)
Get
same procedure is followed to find the node corresponding to the key and the obj value is returned, if not found throws NotFoundException
time complexity-O(logn)
Address
same procedure is followed to find the node but while iterating through the tree R is addded to a string if it goes right and L if left, and if element is found it returns that string or else throws the same exception.
time complexity-O(logn)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Here key for the given input is of type Key<String,String> which has two generic fields and two methods, one is toString which returns the added string value of the two generic fields and the other is compareTo which compared two keys
     obj is of type Student which stores all the information of students.

