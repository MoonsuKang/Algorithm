class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(0)  # 결과 리스트의 시작을 위한 더미 헤드
        current = dummy_head
        carry = 0  # 올림수를 저장하기 위한 변수
        
        while l1 is not None or l2 is not None:
            # l1과 l2의 값이 없으면 0으로 처리
            val1 = l1.val if l1 is not None else 0
            val2 = l2.val if l2 is not None else 0
            
            # 두 노드의 값을 더하고 carry를 더해 총합을 구함
            total = val1 + val2 + carry
            carry = total // 10  # carry는 총합을 10으로 나눈 몫
            new_digit = total % 10  # 새로운 노드에 저장될 값은 총합을 10으로 나눈 나머지
            
            # 새로운 노드를 만들어 결과 리스트에 추가
            current.next = ListNode(new_digit)
            current = current.next
            
            # l1과 l2를 다음 노드로 이동
            if l1 is not None:
                l1 = l1.next
            if l2 is not None:
                l2 = l2.next
        
        # 마지막 carry가 남아있다면 새로운 노드를 추가
        if carry > 0:
            current.next = ListNode(carry)
        
        return dummy_head.next  # 더미 헤드 다음 노드부터가 실제 결과 리스트의 시작