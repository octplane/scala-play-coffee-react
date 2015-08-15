define [
  'react'
  'jquery'
  ], (React, jQuery) ->

  PhraseList = React.createClass
    getInitialState: ->
      hasLoaded: false
      events: []
    render: ->
      { div } = React.DOM
      if @state.hasLoaded
        div {}, JSON.stringify @state.events
      else
        div {}
    componentDidMount: ->
      phraseListApi = jsRoutes.controllers.Phrase.list()
      phraseListApi.ajax()
      .done (result) =>
        @setState
          events: result
          hasLoaded: true
        # if @isMounted()
        #   @setState
        #   events: result.response
        #   hasLoaded: true
      .fail (jqXHR, textStatus, errorThrown) =>
        resultCode = jqXHR.status
        if @isMounted()
          @setState
            events: []
            hasLoaded: true

  PhraseList
