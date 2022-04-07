import React from "react";
import leftNav from "./index.module.css";

export default function LeftNav() {
  const goToAdmin = () => {
    const w = window.open("about:blank");
    w.location.href = "http://localhost:8080";
  };
  return (
    <div className={leftNav.leftNav}>
      <ul>
        <li>
          <div>Sale</div>
        </li>
        <li>
          <div onClick={goToAdmin}>Store</div>
        </li>
        <li>
          <div>Food</div>
        </li>
      </ul>
    </div>
  );
}
