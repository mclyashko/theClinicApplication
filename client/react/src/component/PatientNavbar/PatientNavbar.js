import React from 'react';

function PatientNavbar(props) {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="/home_patient">ParaMedic</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <a className="nav-link" href="/list_of_services">Услуги</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/contact_details">Контактные данные</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/quiz">Квиз</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/covid_stat">Статистика по коронавирусу</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/review">Отзывы</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/logout">Выйти</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    );
}

export default PatientNavbar;
