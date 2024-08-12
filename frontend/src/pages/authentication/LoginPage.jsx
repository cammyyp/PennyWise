import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCoins } from "@fortawesome/free-solid-svg-icons";
import { useEffect, useState } from "react";

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    setError("");
  }, []);

  const handleLogin = () => {
    if (!username) {
      setError("Please enter a username");
    } else if (!password) {
      setError("Please enter a password");
    }
  };

  return (
    <>
      <div className="flex justify-center items-center min-h-screen flex-col gap-4">
        {error && (
          <div role="alert" className="alert alert-error w-96">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6 shrink-0 stroke-current"
              fill="none"
              viewBox="0 0 24 24"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"
              />
            </svg>
            <span>{error}</span>
          </div>
        )}

        <div className="card bg-base-100 w-96 shadow-xl card-bordered border-slate-300">
          <div className="card-body">
            <div className="flex items-center gap-2 mb-3">
              <h2 className="card-title text-2xl">Penny Wise</h2>
              <FontAwesomeIcon
                icon={faCoins}
                style={{ color: "#FFD43B" }}
                size="xl"
              />
            </div>
            <input
              type="text"
              placeholder="Username"
              className="input input-bordered flex items-center gap-2 hover:border-indigo-500"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            <input
              type="password"
              placeholder="Password"
              className="input input-bordered flex items-center gap-2 hover:border-indigo-500"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <Link
              to={"/reset-password"}
              className="link link-primary w-2/5 mb-3"
            >
              Forgot Password?
            </Link>
            <div className="card-actions justify-start">
              <button className="btn bg-indigo-500 w-32" onClick={handleLogin}>
                Login
              </button>
              <button className="btn border-indigo-500 w-24">Sign up</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
