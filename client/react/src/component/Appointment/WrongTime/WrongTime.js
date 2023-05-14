import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";
import {LIST_OF_SERVICES_ROUTE, WRONG_TIME_ROUTE} from "../../../util/consts";

function WrongTime(props) {
    return (
        <Wrapper>
            <h1>ВЫБРАННОЕ ВРЕМЯ НЕДОСТУПНО ДЛЯ ЗАПИСИ</h1>
            <p className="text-center text-light">
                <a href={LIST_OF_SERVICES_ROUTE} className="text-light">Изменить время записи</a>
            </p>
        </Wrapper>
    );
}

export default WrongTime;
