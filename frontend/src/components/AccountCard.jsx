export default function AccountCard({ accountName, type, accountValue }) {
  return (
    <>
      <div className="card bg-base-100 w-96 shadow-xl border border-slate-400">
        <div className="card-body">
          <h2 className="card-title mb-2">
            {accountName}
            <div
              className={`badge badge-${
                type === "Safe" ? "success" : "warning"
              }`}
            >
              {type}
            </div>
          </h2>
          <p>
            <b>Account value:</b> £{accountValue}
          </p>
          <div className="card-actions justify-start mt-4">
            <div className="badge badge-outline bg-warning">Update</div>
            <div className="badge badge-outline bg-error">Remove</div>
          </div>
        </div>
      </div>
    </>
  );
}
