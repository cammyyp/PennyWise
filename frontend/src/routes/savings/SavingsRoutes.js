import HomePage from "../../pages/savings/SavingsPage";
import AddOrUpdatePage from "../../pages/savings/AddOrUpdatePage";

const savingsRoutes = [
  { path: "/savings", component: HomePage },
  { path: "/savings/add", component: AddOrUpdatePage },
  { path: "/savings/:id/update", component: AddOrUpdatePage },
];

export default savingsRoutes;
