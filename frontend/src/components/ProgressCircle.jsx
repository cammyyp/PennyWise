export default function ProgressCircle({ progress }) {
  return (
    <>
      <div
        className="radial-progress"
        style={{
          "--value": "77",
          "--size": "12rem",
          "--thickness": "0.5rem",
        }}
        role="progressbar"
      >
        {progress}%
      </div>
    </>
  );
}
