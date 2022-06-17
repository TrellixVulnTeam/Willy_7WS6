// Importations
import React, { useState } from "react";
import styled from "styled-components";
import { IconContext } from "react-icons";
import { FaFacebook } from "react-icons/fa";

function Footer() {
  return (
    <>
      <IconContext.Provider value={{ className: "iconos" }}>
        <FooterContainer>
          <footer className="site-footer">
            <div className="container">
              <div className="row">
                <div className="col-sm-12 col-md-6">
                  <h6>About</h6>
                  <p className="text-justify">
                    Scanfcode.com <i>CODE WANTS TO BE SIMPLE </i> is an
                    initiative to help the upcoming programmers with the code.
                    Scanfcode focuses on providing the most efficient code or
                    snippets as the code wants to be simple. We will help
                    programmers build up concepts in different programming
                    languages that include C, C++, Java, HTML, CSS, Bootstrap,
                    JavaScript, PHP, Android, SQL and Algorithm.
                  </p>
                </div>

                <div className="col-xs-6 col-md-3">
                  <h6>Categories</h6>
                  <ul className="footer-links">
                    <li>
                      <a href="/">C</a>
                    </li>
                    <li>
                      <a href="/">UI Design</a>
                    </li>
                    <li>
                      <a href="/">PHP</a>
                    </li>
                    <li>
                      <a href="/">Java</a>
                    </li>
                  </ul>
                </div>

                <div className="col-xs-6 col-md-3">
                  <h6>Quick Links</h6>
                  <ul className="footer-links">
                    <li>
                      <a href="projects">Projects</a>
                    </li>
                    <li>
                      <a href="awards">Awards</a>
                    </li>
                    <li>
                      <a href="about-me">About Me</a>
                    </li>
                    <li>
                      <a href="contact-me">Contact Me</a>
                    </li>
                  </ul>
                </div>
              </div>
              <hr />
            </div>
            <div className="container">
              <div className="row">
                <div className="col-md-8 col-sm-6 col-xs-12">
                  <p className="copyright-text">
                    Made With Love by
                    <a href="/"> Black Dog Solutions</a> 2022.
                  </p>
                </div>

                <div className="col-md-4 col-sm-6 col-xs-12">
                  <ul className="social-icons">
                    <li>
                      <a className="facebook" href="/">
                        <FaFacebook />
                      </a>
                    </li>
                    <li>
                      <a className="twitter" href="/">
                        <i className="fa fa-twitter"></i>
                      </a>
                    </li>
                    <li>
                      <a className="dribbble" href="/">
                        <i className="fa fa-dribbble"></i>
                      </a>
                    </li>
                    <li>
                      <a className="linkedin" href="/">
                        <i className="fa fa-linkedin"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </footer>
        </FooterContainer>
      </IconContext.Provider>
    </>
  );
}
export default Footer;

const FooterContainer = styled.nav`
  .site-footer {
    background-color: #333;
    padding: 15px 0 10px;
    font-size: 15px;
    line-height: 24px;
    color: white;
  }
  .site-footer hr {
    border-top-color: white;
    opacity: 0.5;
  }
  .site-footer hr.small {
    margin: 20px 0;
  }
  .site-footer h6 {
    color: #fff;
    font-size: 16px;
    text-transform: uppercase;
    margin-top: 5px;
    letter-spacing: 2px;
  }
  .site-footer a {
    color: white;
  }
  .site-footer a:hover {
    color: #3366cc;
    text-decoration: none;
  }
  .footer-links {
    padding-left: 0;
    list-style: none;
  }
  .footer-links li {
    display: block;
  }
  .footer-links a {
    color: white;
  }
  .footer-links a:active,
  .footer-links a:focus,
  .footer-links a:hover {
    color: #3366cc;
    text-decoration: none;
  }
  .footer-links.inline li {
    display: inline-block;
  }
  .site-footer .social-icons {
    text-align: right;
  }
  .site-footer .social-icons a {
    width: 40px;
    height: 40px;
    line-height: 40px;
    margin-left: 6px;
    margin-right: 0;
    border-radius: 100%;
    background-color: white;
  }
  .copyright-text {
    margin: 0;
  }
  @media (max-width: 991px) {
    .site-footer [className^="col-"] {
      margin-bottom: 30px;
    }
  }
  @media (max-width: 767px) {
    .site-footer {
      padding-bottom: 0;
    }
    .site-footer .copyright-text,
    .site-footer .social-icons {
      text-align: center;
    }
  }
  .social-icons {
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
  }
  .social-icons li {
    display: inline-block;
    margin-bottom: 4px;
  }
  .social-icons li.title {
    margin-right: 15px;
    text-transform: uppercase;
    color: black;
    font-weight: 700;
    font-size: 13px;
  }
  .social-icons a {
    background-color: black;
    color: black;
    font-size: 16px;
    display: inline-block;
    line-height: 44px;
    width: 44px;
    height: 44px;
    text-align: center;
    margin-right: 8px;
    border-radius: 100%;
    -webkit-transition: all 0.2s linear;
    -o-transition: all 0.2s linear;
    transition: all 0.2s linear;
  }
  .social-icons a:active,
  .social-icons a:focus,
  .social-icons a:hover {
    color: #fff;
    background-color: #29aafe;
  }
  .social-icons.size-sm a {
    line-height: 34px;
    height: 34px;
    width: 34px;
    font-size: 14px;
  }
  .social-icons a.facebook:hover {
    background-color: #3b5998;
  }
  .social-icons a.twitter:hover {
    background-color: #00aced;
  }
  .social-icons a.linkedin:hover {
    background-color: #007bb6;
  }
  .social-icons a.dribbble:hover {
    background-color: #ea4c89;
  }
  @media (max-width: 767px) {
    .social-icons li.title {
      display: block;
      margin-right: 0;
      font-weight: 600;
    }
  }
`;
