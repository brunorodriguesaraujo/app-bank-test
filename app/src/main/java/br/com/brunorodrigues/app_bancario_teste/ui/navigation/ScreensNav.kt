package br.com.brunorodrigues.app_bancario_teste.ui.navigation

import br.com.brunorodrigues.app_bancario_teste.domain.entity.User
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class PaymentsDetails(val data: String)

@Serializable
data class UserNav(
    val customerName: String,
    val accountNumber: String,
    val branchNumber: String,
    val checkingAccountBalance: Double,
    val id: String
) {
    fun toDomain() = User(
        customerName = customerName,
        accountNumber = accountNumber,
        branchNumber = branchNumber,
        checkingAccountBalance = checkingAccountBalance,
        id = id
    )

    companion object {
        fun fromDomain(user: User) = UserNav(
            customerName = user.customerName,
            accountNumber = user.accountNumber,
            branchNumber = user.branchNumber,
            checkingAccountBalance = user.checkingAccountBalance,
            id = user.id
        )
    }
}