Ý tưởng giải quyết bài 3 

* kiếm thức áp dụng: tổ hợp và chỉnh hợp
  -> ví dụ : 2 2 1 1 -> thì số hoán vị phân biệt: 4!/2!*2! -> 2 2 1 1 | 2 1 2 1 | 2 1 1 2 | 1 2 1 2 | 1 1 2 2 | 1 2 2 1| -> 6 cách sắp xếp

* Tương tư với n và k ban đầu 
+ Ta có số loại bước có thể bước là 1 -> k 
+ Với mỗi loại bước ta có số bước có thể có của loại bước đó
+ Ví dụ test case n = 6, k = 2
  - gọi i là loại bước -> i = {1, 2}
  - gọi map<Integer, Interger> la map chua key la loai bước (i) va value la số lần bước tối ta cua loại bước với n bước, map = {(1, 6); (2, 3)}
  - với trường hợp đầu tiên là 1 bước thì luôn luôn chỉ có 1 cách để bước nó
  - với trường hợp còn lại, nó lại chia ra các trường hợp
    . có 1 bước 2 bậc thang -> có 1 bước loại 2 và tập hop các bước loại x < k -> (1 + x)!/(1!*x!) -> gọi lại bài toán ban đầu với n thay đổi là n - 2, và k = k - 1
    . có 2 bước 2 bậc thang -> có 2 bước loại 2 và tập hop các bước loại x < k -> (2 + x)!/(2!*x!) -> gọi lại bài toán ban đầu với n thay đổi là n - 4, và k = k - 1
    . có 3 bước 2 bậc thang -> có 3 bước loại 2 và tập hop các bước loại x < k -> (3 + x)!/(3!*x!) -> gọi lại bài toán ban đầu với n thay đổi là n - 6, và k = k - 1

* Với test case đề bài 6 2 -> 13 pass
** Nhưng có vẽ là bài làm chưa chắc chắn lắm **
** E cần nhiều testcase hơn để test cho ý tưởng này **
