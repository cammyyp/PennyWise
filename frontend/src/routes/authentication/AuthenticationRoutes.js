import LoginPage from "../../pages/Authentication/LoginPage";
import RegisterPage from "../../pages/authentication/RegisterPage";
import PasswordResetPage from "../../pages/Authentication/PasswordResetPage";

const authenticatedRoutes = [
  { path: "/", component: LoginPage },
  { path: "/register", component: RegisterPage },
  { path: "/reset-password", component: PasswordResetPage },
];

export default authenticatedRoutes;
