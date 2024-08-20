import AddOrUpdatePage from "../../pages/income-and-expense-management/AddOrUpdatePage";
import IncomeAndExpensesPage from "../../pages/income-and-expense-management/IncomeAndExpensesPage";

const incomeAndExpenseRoutes = [
  { path: "/incomes-and-expenses", component: IncomeAndExpensesPage },
  { path: "/income/add", component: AddOrUpdatePage },
  { path: "/income/:id/update", component: AddOrUpdatePage },
  { path: "/expense/add", component: AddOrUpdatePage },
  { path: "/expense/:id/update", component: AddOrUpdatePage },
];

export default incomeAndExpenseRoutes;
