import authenticatedRoutes from "./authentication/AuthenticationRoutes";
import homeRoutes from "./home/HomeRoutes";

const routes = [...authenticatedRoutes, ...homeRoutes];

export default routes;
