import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCoins, faEllipsis } from "@fortawesome/free-solid-svg-icons";

export default function NavBar() {
  return (
    <>
      <div className="navbar bg-indigo-500">
        <div className="flex-none">
          <div className="dropdown">
            <div
              tabIndex={0}
              role="button"
              className="btn btn-ghost btn-circle"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-5 w-5"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M4 6h16M4 12h16M4 18h7"
                />
              </svg>
            </div>
            <ul
              tabIndex={0}
              className="menu menu-sm dropdown-content bg-base-100 rounded-box z-[1] mt-3 w-52 p-2 shadow"
            >
              <li>
                <Link to={"/home"}>Dashboard</Link>
              </li>
              <li>
                <Link to={"/savings"}>Savings</Link>
              </li>
              <li>
                <Link to={"/incomes-and-expenses"}>Income & Expenses</Link>
              </li>
              <li>
                <Link>Categories</Link>
              </li>
              <li>
                <Link>Reports</Link>
              </li>
            </ul>
          </div>
        </div>

        <div className="flex-1">
          <div className="flex items-center gap-2 mb-3">
            <Link to={"/home"} className="flex-1 text-2xl">
              Penny Wise
            </Link>
            <FontAwesomeIcon
              icon={faCoins}
              style={{ color: "#FFD43B" }}
              size="xl"
            />
          </div>
        </div>
        <div className="flex-none">
          <Link to={"/settings"} className="mr-2">
            <FontAwesomeIcon icon={faEllipsis} size="xl" />
          </Link>
        </div>
      </div>
    </>
  );
}
