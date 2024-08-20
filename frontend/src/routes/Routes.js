import authenticatedRoutes from "./authentication/AuthenticationRoutes";
import homeRoutes from "./home/HomeRoutes";
import savingsRoutes from "./savings/SavingsRoutes";
import incomeAndExpenseRoutes from "./income-and-expense-management/IncomeAndExpenseRoutes";

const routes = [
  ...authenticatedRoutes,
  ...homeRoutes,
  ...savingsRoutes,
  ...incomeAndExpenseRoutes,
];

export default routes;
