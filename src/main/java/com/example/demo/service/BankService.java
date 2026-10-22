package com.example.demo.service;

import com.example.demo.bo.BankAccount;
import com.example.demo.bo.ServiceResponse;
import com.example.demo.bo.WithdrawRequestDTO;
import com.example.demo.dao.IBankDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankService {

    // java => Je cherche une classe avec @Component qui implement au moins  IBankDAO
    @Autowired
    IBankDAO bankDAO;

    public ServiceResponse withdraw(WithdrawRequestDTO withdrawRequestDTO){
        // Cas 1 : montant negatif
        if (withdrawRequestDTO.amount < 1){
            return new ServiceResponse("ERR-701", "Le montant doit être positif");
        }

        // Récupérer le compte banquaire
        BankAccount bankAccount = bankDAO.selectById(withdrawRequestDTO.id);

        // Cas 2 : pas assez d'argent (wallet plus petit que montant à retirer)
        if (bankAccount.wallet < withdrawRequestDTO.amount){
            return new ServiceResponse("ERR-702", "Montant insuffisant");
        }

        // Appliquer le retrait
        bankAccount.wallet -= withdrawRequestDTO.amount;

        // Message retour
        String message = String.format("Le retrait de %d a été effectué avec succès ! Il reste %d dans le compte",
                withdrawRequestDTO.amount, bankAccount.wallet);
        return new ServiceResponse("VD-200", message);
    }
}
