### Input:

* You have a list of item ids = [1, 2, 3, 1, 5, 4, 2, 8, 10, 2].
* Two sources to fetch item:
    * [Api](./source/Api.java)#getItems(List\<Integer> idList)
    * [Db](./source/Db.java)#getItem(int id)

### Output:

* Return a Flux\<Item> in the same order of input item ids.

### Description:

01. If item id is even fetch it from Api
02. For all odd item ids, fetch items from Db
03. collect all the items got from 01 and 02, order should be
    maintained from initially asked item id list.
