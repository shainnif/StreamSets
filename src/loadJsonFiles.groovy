def fileStore = "/home/shaine/IdeaProjects/StreamSets/jsonfiles/"

def sdc = [records:[:],
                                                     state: [:]]

sdc.state['cache'] = [:]

import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()

new File(fileStore).traverse(type: groovy.io.FileType.FILES) { it ->
    if (it.name.endsWith("json"))
        sdc.state['cache'][it.name] = jsonSlurper.parse(it)
}

print(sdc.state['cache'])

