import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";

function WrongTime(props) {
    return (
        <Wrapper>
            <h1>ВЫБРАННОЕ ВРЕМЯ НЕДОСТУПНО ДЛЯ ЗАПИСИ</h1>
            <p className="text-center text-light">
                <a href="/list_of_services" className="text-light">Изменить время записи</a>
            </p>
        </Wrapper>
    );
}

export default WrongTime;
