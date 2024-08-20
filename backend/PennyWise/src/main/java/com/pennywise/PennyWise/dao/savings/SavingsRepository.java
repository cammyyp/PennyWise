package com.pennywise.PennyWise.dao.savings;

import com.pennywise.PennyWise.entity.savings.SavingsAccount;
import com.pennywise.PennyWise.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface SavingsRepository  extends JpaRepository<SavingsAccount, Integer> {

    List<SavingsAccount> findByUserId(User user);
}
