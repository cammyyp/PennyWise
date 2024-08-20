import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCoins } from "@fortawesome/free-solid-svg-icons";
import { useEffect, useState } from "react";
import ErrorMessage from "../../components/ErrorMessage";

export default function PasswordResetPage() {
  const [username, setUsername] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    setError("");
  }, [username]);

  const handleResetPassword = () => {
    if (!username) {
      setError("Please enter a username");
    }
  };

  return (
    <>
      <div className="flex justify-center items-center min-h-screen flex-col gap-4 bg-indigo-500">
        {error && <ErrorMessage errorMessage={error} />}

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
            <div className="card-actions justify-start">
              <button
                className="btn bg-indigo-500 w-40 text-white"
                onClick={handleResetPassword}
              >
                Reset password
              </button>

              <Link to={"/"} className="link link-primary w-2/5 mb-3 ">
                Back to login
              </Link>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
