package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    public BorrowRecord findByBookIdAndUserId(int bookId, int userId);
    public List<BorrowRecord> findByBookId(int bookId);
    public List<BorrowRecord> findByUserId(int userId);

    @Query(value = "select return_date from t_borrow_record", nativeQuery = true)
    public List<String> getReturnDate();

    @Query(value = "select user_id from t_borrow_record where return_date = ?1", nativeQuery = true)
    public List<Integer> getUserId(String returnDate);

    @Query(value = "select book_id from t_borrow_record where return_date = ?1", nativeQuery = true)
    public List<Integer> getBookId(String returnDate);

    @Query(value = "select id from t_borrow_record where return_date = ?1", nativeQuery = true)
    public List<Integer> getId(String returnDate);

//    @Query(value = "select * from t_borrow_record where id = ?1", nativeQuery = true)
//    public BorrowRecord getRecord(int recordId);
    public BorrowRecord findBorrowRecordById(int recordId);
}
